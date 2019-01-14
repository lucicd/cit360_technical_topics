/*
 * The Movie class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package moviesearch;

import java.util.List;

/**
 * Keeps data about movies
 *
 * @author Drazen
 */
public class Movie {

    // tconst (string) - alphanumeric unique identifier of the title
    private String tconst;

    /**
     * Get the value of tconst
     *
     * @return the value of tconst
     */
    public String getTconst() {
        return tconst;
    }

    /**
     * Set the value of tconst
     *
     * @param tconst new value of tconst
     */
    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    // titleType (string) – the type/format of the title 
    // (e.g. movie, short, tvseries, tvepisode, video, etc)
    private String titleType;

    /**
     * Get the value of titleType
     *
     * @return the value of titleType
     */
    public String getTitleType() {
        return titleType;
    }

    /**
     * Set the value of titleType
     *
     * @param titleType new value of titleType
     */
    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    // primaryTitle (string) – the more popular title / the title used by the 
    // filmmakers on promotional materials at the point of release
    private String primaryTitle;

    /**
     * Get the value of primaryTitle
     *
     * @return the value of primaryTitle
     */
    public String getPrimaryTitle() {
        return primaryTitle;
    }

    /**
     * Set the value of primaryTitle
     *
     * @param primaryTitle new value of primaryTitle
     */
    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    // originalTitle (string) - original title, in the original language
    private String originalTitle;

    /**
     * Get the value of originalTitle
     *
     * @return the value of originalTitle
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * Set the value of originalTitle
     *
     * @param originalTitle new value of originalTitle
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    // isAdult (boolean) - 0: non-adult title; 1: adult title
    private boolean isAdult;

    /**
     * Get the value of isAdult
     *
     * @return the value of isAdult
     */
    public boolean isIsAdult() {
        return isAdult;
    }

    /**
     * Set the value of isAdult
     *
     * @param isAdult new value of isAdult
     */
    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    // startYear (YYYY) – represents the release year of a title. 
    // In the case of TV Series, it is the series start year
    private int startYear;

    /**
     * Get the value of startYear
     *
     * @return the value of startYear
     */
    public int getStartYear() {
        return startYear;
    }

    /**
     * Set the value of startYear
     *
     * @param startYear new value of startYear
     */
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    // endYear (YYYY) – TV Series end year. 0 for all other title types
    private int endYear;

    /**
     * Get the value of endYear
     *
     * @return the value of endYear
     */
    public int getEndYear() {
        return endYear;
    }

    /**
     * Set the value of endYear
     *
     * @param endYear new value of endYear
     */
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    // runtimeMinutes – primary runtime of the title, in minutes
    private int runtimeMinutes;

    /**
     * Get the value of runtimeMinutes
     *
     * @return the value of runtimeMinutes
     */
    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    /**
     * Set the value of runtimeMinutes
     *
     * @param runtimeMinutes new value of runtimeMinutes
     */
    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    // genres (string array) – includes up to three genres associated with the movie
    private List<String> genres;

    /**
     * Get the value of genres
     *
     * @return the value of genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * Set the value of genres
     *
     * @param genres new value of genres
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie {" + 
                "\n\ttconst = " + tconst + 
                "\n\ttitleType = " + titleType + 
                "\n\tprimaryTitle = " + primaryTitle + 
                "\n\toriginalTitle = " + originalTitle + 
                "\n\tisAdult = " + isAdult + 
                "\n\tstartYear = " + startYear + 
                "\n\tendYear = " + endYear + 
                "\n\truntimeMinutes = " + runtimeMinutes + 
                "\n\tgenres = " + genres + '}';
    }

}
