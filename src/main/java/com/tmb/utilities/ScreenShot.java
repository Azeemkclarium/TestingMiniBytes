package com.tmb.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.tmb.drivers.DriverManager;
import com.tmb.enums.ColorsEnum;
import com.tmb.enums.MarkSideEnum;

public final class ScreenShot {

	public static String takeScreenShot_B64(String message) {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	public static String takeScreenshot_B64(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		// 1. Back up any existing border-radius or outline settings String
		String originalBorderRadius = element.getCssValue("border-radius");

		// 2. Apply a thick 4px dark red outline marker
		js.executeScript("arguments[0].style.outline = '2px solid #8B0000';", element);

		// 3. Push it 8px wider out from the text container
		js.executeScript("arguments[0].style.outlineOffset = '8px';", element);

		// 4. Force perfectly sharp square corners (0px radius)
		js.executeScript("arguments[0].style.borderRadius = '0px';", element);

		// 5. Capture the base64 screenshot String base64Code = ((TakesScreenshot)
		String base64Code = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

		// 6. Clean up: reset everything to preserve original UI design
		js.executeScript("arguments[0].style.outline = '';", element);
		js.executeScript("arguments[0].style.outlineOffset = '';", element);
		js.executeScript("arguments[0].style.borderRadius = '" + originalBorderRadius + "';", element);

		return base64Code;
	}
	
	public static String takeScreenshot_B64(WebElement element, ColorsEnum color, String text, MarkSideEnum side) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

		String originalBorderRadius = element.getCssValue("border-radius");

		// Extract values from Enums
		String hexColor = color.getHexCode();
		String sideStr = side.getSide();

		// Set your smart defaults right here inside the method
		String fontSize = "14px";
		String markerThickness = "2px";
		String markgapSize = "6px";

		// Removed the flaky CSS outline commands that were failing to render on table elements.
		// Instead, we inject a native SVG <rect> inside the canvas script below.

		String injectSvgScript = "var rect = arguments[0].getBoundingClientRect();"
				+ "var scrollTop = window.pageYOffset || document.documentElement.scrollTop;"
				+ "var scrollLeft = window.pageXOffset || document.documentElement.scrollLeft;" +

				"var targetX, startX, targetY, startY, textAnchor;" +
				"var side = arguments[4].toLowerCase();" +

				// Extract numerical values from strings for fine-tuned math calculations
				"var gapNum = parseFloat(arguments[6]) || 6;" + "var thickNum = parseFloat(arguments[5]) || 2;"
				+ "var totalOffset = gapNum + thickNum + 4;" +

				"if (side === 'right') {" 
				+ "    targetY = rect.top + scrollTop + (rect.height / 2);" 
				+ "    startY = targetY;"
				+ "    targetX = rect.right + scrollLeft + totalOffset;"
				+ "    startX = targetX + 60;" 
				+ "    textAnchor = 'start';" 
				+ "} else if (side === 'left') {"
				+ "    targetY = rect.top + scrollTop + (rect.height / 2);" 
				+ "    startY = targetY;"
				+ "    targetX = rect.left + scrollLeft - totalOffset;" 
				+ "    startX = targetX - 60;"
				+ "    textAnchor = 'end';" 
				+ "} else if (side === 'top') {"
				+ "    targetX = rect.left + scrollLeft + (rect.width / 2);" 
				+ "    startX = targetX;"
				+ "    targetY = rect.top + scrollTop - totalOffset;" 
				+ "    startY = targetY - 40;"
				+ "    textAnchor = 'middle';" 
				+ "} else if (side === 'bottom') {"
				+ "    targetX = rect.left + scrollLeft + (rect.width / 2);" 
				+ "    startX = targetX;"
				+ "    targetY = rect.bottom + scrollTop + totalOffset;" 
				+ "    startY = targetY + 40;"
				+ "    textAnchor = 'middle';" 
				+ "}" +

				"var svgOverlay = document.createElement('div');" + "svgOverlay.id = 'selenium-screenshot-overlay';"
				+ "svgOverlay.style.position = 'absolute';" + "svgOverlay.style.top = '0px';"
				+ "svgOverlay.style.left = '0px';" + "svgOverlay.style.width = '100%';"
				+ "svgOverlay.style.height = document.documentElement.scrollHeight + 'px';"
				+ "svgOverlay.style.pointerEvents = 'none';" + "svgOverlay.style.zIndex = '999999';" +

				"svgOverlay.innerHTML = \"<svg width='100%' height='100%'>\" +" + "  \"<defs>\" +"
				+ "    \"<marker id='arrow' viewBox='0 0 10 10' refX='5' refY='5' markerWidth='6' markerHeight='6' orient='auto'>\" +"
				+ "      \"<path d='M 0 0 L 10 5 L 0 10 z' fill='\" + arguments[1] + \"'/>\" +" + "    \"</marker>\" +"
				+ "  \"</defs>\" +" 
				// FIX: Draws the highlighting square box natively using an SVG rect that sits on top of everything
				+ "  \"<rect x='\" + (rect.left + scrollLeft - gapNum) + \"' y='\" + (rect.top + scrollTop - gapNum) + \"' width='\" + (rect.width + (gapNum * 2)) + \"' height='\" + (rect.height + (gapNum * 2)) + \"' stroke='\" + arguments[1] + \"' stroke-width='\" + arguments[5] + \"' fill='none' />\" +"
				// Generates a direct path between start positions and target positions dynamically
				+ "  \"<path d='M \" + startX + \" \" + startY + \" L \" + targetX + \" \" + targetY + \"' stroke='\" + arguments[1] + \"' stroke-width='\" + arguments[5] + \"' fill='none' marker-end='url(#arrow)' />\" +"
				// Dynamically places the label text based on direction
				+ "  \"<text x='\" + (side === 'right' ? (startX + 10) : side === 'left' ? (startX - 10) : startX) + \"' y='\" + (side === 'top' ? (startY - 10) : side === 'bottom' ? (startY + 20) : (startY + 5)) + \"' fill='\" + arguments[1] + \"' font-family='Arial, sans-serif' font-weight='bold' font-size='\" + arguments[3] + \"' text-anchor='\" + textAnchor + \"'>\" + arguments[2] + \"</text>\" +"
				+ "  \"</svg>\";" 
				+ "document.body.appendChild(svgOverlay);";
		
		// Pass the arguments safely down to the JavaScript executor pool
		js.executeScript(injectSvgScript, element, hexColor, text, fontSize, sideStr, markerThickness, markgapSize);

		String base64Code = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

		// Clean up overlay element completely
		js.executeScript("var overlay = document.getElementById('selenium-screenshot-overlay'); if(overlay) overlay.remove();");

		return base64Code;
	}


}
