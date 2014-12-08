package marriagenda.controller.utilities;

import android.media.Image;

public class Page {

	private String name;
	private Image image;
	private String comments;
	private Image signature;

	public Page(Image rImage, String comments, Image signature) {

		this.setImage(rImage);
		this.setComments(comments);
		this.setSignature(signature);

	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Image getSignature() {
		return signature;
	}

	public void setSignature(Image signature) {
		this.signature = signature;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
