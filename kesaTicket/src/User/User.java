package User;

import has_a.Identifiable;

public class User implements Identifiable {
	private String email;
	private String password;
	private boolean isAdmin;
	private boolean isStudent;

    public User(String email, String password, boolean isAdmin, boolean isStudent) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isStudent = isStudent;
    }

    @Override
    public int getId() {
        return getEmail().hashCode(); // Using email hash code as the unique user ID
    }

	public String getEmail() {
		return email;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
}