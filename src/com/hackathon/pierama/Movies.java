package com.hackathon.pierama;

/* Only getter Functions are meant to be used from this class.
 * Setter Functions are Public too but isn't needed to used by others than JSONParser Class
 */
public class Movies {
	private String category_id;
	private String name;
	private String genre;
	private String Release_Date;
	private String Status;
	private String image;

	public Movies() {
		// TODO Auto-generated constructor stub
	}

	public Movies(String name, String genre, String release_Date, String status,
			String cat_ID, String image) {
		setName(name);
		setGenre(genre);
		setRelease_Date(release_Date);
		setStatus(status);
		setCategory_id(cat_ID);
		setImage(image);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRelease_Date() {
		return Release_Date;
	}

	public void setRelease_Date(String release_Date) {
		Release_Date = release_Date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
