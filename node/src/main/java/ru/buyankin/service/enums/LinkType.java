package ru.buyankin.service.enums;

public enum LinkType {
    GET_DOC("file/get-doc"),
    GET_PHOTO("file/get-photo");

    private final String link;

    LinkType(String link1) {
        this.link = link1;
    }

    @Override
    public String toString() {
        return link;
    }
}
