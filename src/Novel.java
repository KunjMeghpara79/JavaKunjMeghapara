class Novel implements LibraryItems {
    private String title;
    private String author;
    private String sr_no;
    private boolean available;

    Novel(String title,String author,String sr_no,boolean available){
        if(sr_no.length() != 6){
            System.out.println("Invalid Serial number !");
        }else {
            this.title = title;
            this.author = author;
            this.sr_no = sr_no;
            this.available = available;
        }
    }
    @Override
    public void ShowDetail() {
        System.out.println("Novel Details are as follows...");
        System.out.println("Novel Name      :  "+this.title);
        System.out.println("Author name     :  "+this.author);
        System.out.println("Serial number   :  "+this.sr_no);
        System.out.println("Status          :  "+((this.available) ? "Available" : "Not available"));
    }



    public String getSr_no() {
        return this.sr_no;
    }

    public String getAuthor() {
        return this.author;
    }
}