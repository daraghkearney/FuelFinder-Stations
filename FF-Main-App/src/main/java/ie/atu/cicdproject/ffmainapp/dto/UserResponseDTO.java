package ie.atu.cicdproject.ffmainapp.dto;

public class UserResponseDTO {
    private String userID;
    private String userName;
    private String email;

    public UserResponseDTO() {}

    public UserResponseDTO(String userID, String userName, String email) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
    }

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
