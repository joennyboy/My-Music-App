package com.example.android.mymusicapp;

/**
 * {@link Song} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Song {

    /**
     * the artist name
     */

    private String mArtistName;
    /**
     * the music title
     */
    private String mMusicTitle;

    /**
     * Image resource ID for the word
     */
    private int mAudioResourceId;

    public Song(String artistName, String musicTitle, int audioResourceId) {

        mArtistName = artistName;
        mMusicTitle = musicTitle;
        mAudioResourceId = audioResourceId;

    }

    /**
     * Get the name of the artist
     */
    public String getmArtistName() {
        return mArtistName;
    }

    /**
     * Get the title of the song.
     */
    public String getMusicTitle() {
        return mMusicTitle;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;

    }
}



