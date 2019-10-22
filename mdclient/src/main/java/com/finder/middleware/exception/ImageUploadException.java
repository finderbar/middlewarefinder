package com.finder.middleware.exception;

public class ImageUploadException extends AbstractPlatformDomainRuleException {
	private static final long serialVersionUID = 1L;
    public ImageUploadException() {
        super("error.msg.image.type.upload", "Only image files of type GIF,PNG and JPG are allowed ");
    }
}
