package gov.saanjh.user.domain;

public interface UserConstants {

    String INIT="/init";
    String CONFIRM= "/confirm";
    String SIGN_UP="/signUp";
    String LOGIN="/login";
    String USER="/user";
    String ORG="/organization";
    String EXTRACT_CLAIMS="/extract-claims";
    String ID="/{orgId}";
    String CREATE_GROUP="/create-group";
    String DELETE_GROUP="/delete-group";
    String ASSIGN_ROLE_TO_GROUP="/assignRoleToGroup";
    String LOGOUT = "/logout";
    String FORGET_PASSWORD = "/forget-password";
    String CONFIRM_PASSWORD = "/confirm-password";
    String FILE="/file";
    String UPLOAD="/upload";
    String IMAGE_URL="/imageUrl";
    String DELETE="/delete";
    String NO_IMAGE="no_image";
    String BUCKET_S3_IMG_URL="https://%s.s3.%s.amazonaws.com/%s";
}
