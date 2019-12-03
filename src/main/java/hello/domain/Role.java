package hello.domain;

public enum Role {
    USER, TEACHER, MODERATOR, ADMIN;
    public String getAuthority(){
        return name();
    }
}
