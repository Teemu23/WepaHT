/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary;

/**
 *
 * @author Teemu
 */
public class RestBook {
    public enum Preview { noview, full };
    public static class Authors{
        private String name,url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        
    }
    public static class Identifiers {
        String isbn_10, isbn_13, lccn, oclc, goodreads;

        public String getIsbn_10() {
            return isbn_10;
        }

        public void setIsbn_10(String isbn_10) {
            this.isbn_10 = isbn_10;
        }

        public String getIsbn_13() {
            return isbn_13;
        }

        public void setIsbn_13(String isbn_13) {
            this.isbn_13 = isbn_13;
        }

        public String getLccn() {
            return lccn;
        }

        public void setLccn(String lccn) {
            this.lccn = lccn;
        }

        public String getOclc() {
            return oclc;
        }

        public void setOclc(String oclc) {
            this.oclc = oclc;
        }

        public String getGoodreads() {
            return goodreads;
        }

        public void setGoodreads(String goodreads) {
            this.goodreads = goodreads;
        }
            
    }
    public static class Classifications{
        String lc_classifications,dewey_decimal_class;

        public String getLc_classifications() {
            return lc_classifications;
        }

        public void setLc_classifications(String lc_classifications) {
            this.lc_classifications = lc_classifications;
        }

        public String getDewey_decimal_class() {
            return dewey_decimal_class;
        }

        public void setDewey_decimal_class(String dewey_decimal_class) {
            this.dewey_decimal_class = dewey_decimal_class;
        }
        
    }
    public static class Subjects{
        String url,name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }
    public static class Publishers{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }
    public static class Excerpts{
        String comment, text;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
        
    }
    public static class Links{
        String url, title;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        
    }
    public static class Cover{
        String small,medium,large;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }
        
    }
    public static class Ebooks{
        String preview_url;

        public String getPreview_url() {
            return preview_url;
        }

        public void setPreview_url(String preview_url) {
            this.preview_url = preview_url;
        }
        
    }
    private Preview preview;
    private String preview_url;
    private String thumbnail_url;
    private Integer number_of_pages;
    private String publish_date;
    private String weight;
    private String url;
    private String title;
    private String bib_key;
    private String info_url;
    private Authors authors;
    private Identifiers identifiers;
    private Classifications classifications;
    private Publishers publishers;
    private Subjects subjects;
    private Excerpts excerpts;
    private Links links;
    private Cover cover;
    private Ebooks ebooks;

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public Integer getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(Integer number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBib_key() {
        return bib_key;
    }

    public void setBib_key(String bib_key) {
        this.bib_key = bib_key;
    }

    public String getInfo_url() {
        return info_url;
    }

    public void setInfo_url(String info_url) {
        this.info_url = info_url;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public Identifiers getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Identifiers identifiers) {
        this.identifiers = identifiers;
    }

    public Classifications getClassifications() {
        return classifications;
    }

    public void setClassifications(Classifications classifications) {
        this.classifications = classifications;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Excerpts getExcerpts() {
        return excerpts;
    }

    public void setExcerpts(Excerpts excerpts) {
        this.excerpts = excerpts;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Ebooks getEbooks() {
        return ebooks;
    }

    public void setEbooks(Ebooks ebooks) {
        this.ebooks = ebooks;
    }

    public Publishers getPublishers() {
        return publishers;
    }

    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
    }
    
    
}
