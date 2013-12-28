package com.robestone.jjump;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;

public class TextCostume extends AbstractCostume {
	
	private Font font;
	private FontRenderContext fontRenderContext;

	private int borderThickness;
	private Color borderColor;
	private Color fillColor;
	private String text;
	
	public TextCostume(String name) {
		this(name, name);
	}
	public TextCostume(String name, String text) {
		super(name);
		this.text = text;
		this.font = Font.decode("Arial");
		this.borderColor = Color.black;
		this.fontRenderContext = new FontRenderContext(font.getTransform(), true, true);
	}
	public FontRenderContext getFontRenderContext() {
		return fontRenderContext;
	}
	public Font getFont() {
		return font;
	}
	public String getText() {
		return text;
	}
	public int getBorderThickness() {
		return borderThickness;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public void setBorderThickness(int borderThickness) {
		this.borderThickness = borderThickness;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
}
