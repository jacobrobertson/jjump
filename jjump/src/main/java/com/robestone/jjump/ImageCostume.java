package com.robestone.jjump;

/**
 * @author Jacob
 */
public class ImageCostume extends AbstractCostume {

	private String imageName;
	
	public ImageCostume(String name) {
		this(name, name);
	}
	public ImageCostume(String name, String imageName) {
		super(name);
		this.imageName = imageName;
	}
	public String getImageName() {
		return imageName;
	}

}
