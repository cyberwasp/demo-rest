package ru.cwasp.demo.rest.resteasy;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;

public class ResteasyUploadForm {

    private byte[] data;
    private String comment;

    public byte[] getData() {
        return data;
    }

    @FormParam("uploadedFile")
    @PartType("application/octet-stream")
    public void setData(byte[] data) {
        this.data = data;
    }

    public String getComment() {
        return comment;
    }

    @FormParam("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

}