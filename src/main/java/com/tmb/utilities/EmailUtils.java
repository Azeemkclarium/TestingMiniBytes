package com.tmb.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

public final class EmailUtils {

	private EmailUtils() {
	};

	public static void sendExtentReportViaEmail(String reportFilePath) {

		File file = new File(reportFilePath);
		Properties prop = new Properties();

		try {
			// 1. Load the properties configuration file safely
			try (FileInputStream fis = new FileInputStream("src/test/resources/Property/emailconfig.properties")) {
				prop.load(fis);
			} catch (Exception e) {
				System.err.println("[WARNING] Could not load config.properties file, utilizing defaults.");
			}

			// 2. Configure the file attachment
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(reportFilePath);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setName(file.getName());

			// 3. Setup the HTML email structure
			HtmlEmail email = new HtmlEmail();

			String smtpHost = prop.getProperty("smtp.host");
			email.setHostName(smtpHost != null ? smtpHost.trim() : "smtp-mail.outlook.com");

			// Configure credentials safely
			String username = prop.getProperty("smtp.username");
			String password = prop.getProperty("smtp.password");

			if (username == null || username.trim().isEmpty()) {
				System.err.println("[ERROR] Missing 'smtp.username' in config file. Email dispatch aborted.");
				return;
			}

			email.setAuthenticator(new DefaultAuthenticator(username.trim(), password != null ? password : ""));

			// 4. Force properties map setup for Outlook 587 STARTTLS FIRST
			String portStr = prop.getProperty("smtp.port");
			String finalPort = (portStr != null) ? portStr.trim() : "587";

			email.setSSLOnConnect(false);
			email.setStartTLSEnabled(true);
			email.setStartTLSRequired(true);

			// CRITICAL STEP: Initialize and alter the session map FIRST before setting the
			// message fields
			Properties sessionProps = email.getMailSession().getProperties();
			sessionProps.put("mail.smtp.port", finalPort);
			sessionProps.put("mail.smtp.starttls.enable", "true");
			sessionProps.put("mail.smtp.starttls.required", "true");
			sessionProps.put("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.3");

			if (finalPort.equals("587")) {
				sessionProps.remove("mail.smtp.socketFactory.class");
				sessionProps.remove("mail.smtp.socketFactory.port");
			} else {
				sessionProps.put("mail.smtp.socketFactory.port", finalPort);
				sessionProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			}

			// 5. NOW set your message fields safely without them getting wiped out
			String emailFrom = prop.getProperty("email.from");
			if (emailFrom != null && !emailFrom.trim().isEmpty()) {
				email.setFrom(emailFrom.trim(), "Automation Test Engine");
			} else {
				email.setFrom(username.trim(), "Automation Test Engine");
			}

			// Parse and append main recipients dynamically
			String toEmails = prop.getProperty("email.to");
			if (toEmails != null && !toEmails.trim().isEmpty()) {
				for (String to : toEmails.split(",")) {
					if (!to.trim().isEmpty()) {
						email.addTo(to.trim());
					}
				}
			} else {
				System.err.println("[ERROR] Recipient email list ('email.to') is empty. Skipping email dispatch.");
				return;
			}

			// Parse and append CC recipients dynamically if they exist
			String ccEmails = prop.getProperty("email.cc");
			if (ccEmails != null && !ccEmails.trim().isEmpty()) {
				for (String cc : ccEmails.split(",")) {
					if (!cc.trim().isEmpty()) {
						email.addCc(cc.trim());
					}
				}
			}

			// Set Subject & HTML Content Message Details
			String subject = prop.getProperty("email.subject");
			email.setSubject(subject != null ? subject.trim() : "Automation Test Execution Report");
			email.setHtmlMsg("<html>"
					+ "<body style='font-family: Arial, sans-serif; font-size: 14px; line-height: 1.6; color: #333333;'>"
					+ "<p>Hi Team,</p>"
					+ "<p>The regression automation test suite execution has been completed successfully.</p>"
					+ "<p>We have attached the comprehensive <b>Extent Report Dashboard</b> to this email for your reference. "
					+ "Kindly review the attachment to track the detailed test execution status, pass/fail matrices, and assertion steps.</p>"
					+ "<p>Do let us know in case any further clarifications are required.</p>" + "<br>"
					+ "<p><b>Thanks and Regards,</b><br>" + "QA Automation Team</p>"
					+ "<br><hr style='border: none; border-top: 1px solid #eeeeee;'>"
					+ "<p style='font-size: 16px; color: #8B0000;'>\r\n"
					+ "  <i>Note: This is an Auto generated email from the automation suite. Please reach out to the \r\n"
					+ "  <a href=\"mailto:GokulS@clarium.tech\" style=\"color: #0000FF; text-decoration: underline;\"> QA Team </a> \r\n"
					+ "  if you have any questions!</i>\r\n"
					+ "</p>"
					+ "</body>" + "</html>");

			// 6. Attach and dispatch the email package completely
			email.attach(attachment);
			System.out.println("[INFO] Attaching report and sending email to stakeholders...");
			email.send();
			System.out.println("[SUCCESS] Extent Report email sent out successfully.");

		} catch (Exception e) {
			System.err.println("[ERROR] Critical failure encountered in automation email distribution pipeline.");
			e.printStackTrace();
		}
	}

}
