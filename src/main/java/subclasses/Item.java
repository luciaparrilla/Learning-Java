package subclasses;

public class Item {
    private String title;
    private String publicationDate;
    private boolean checkedOut = false;

    public Item(String title, String publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public String getDetails() {
        return "Title: " + this.title + ", Publication date: " + this.publicationDate + " Checked Out: " + this.checkedOut;
    }

    public void checkedOut(){
        if (!this.checkedOut) {
            this.checkedOut = true;
            System.out.println(this.title + " has been checked out.");
        }else{
            System.out.println(this.title + " i already checked out.");

        }
    }

    public void returnItem(){
        if (this.checkedOut) {
            this.checkedOut = false;
            System.out.println(this.title + " has been returned");
        }else{
            System.out.println(this.title + " was not checked out.");
        }
    }

}
