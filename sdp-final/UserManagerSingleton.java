class UserManagerSingleton {
    private static UserManagerSingleton instance;
    private UserManager userManager;

    private UserManagerSingleton() {
        userManager = new UserManager();
    }

    public static UserManagerSingleton getInstance() {
        if (instance == null) {
            instance = new UserManagerSingleton();
        }
        return instance;
    }

    public void registerUser(String username, String password) {
        userManager.registerUser(username, password);
    }

    public void loginUser(UserProfile userProfile) {
        userManager.loginUser(userProfile);
    }

    public UserProfile getUser(String username) {
        return userManager.getUser(username);
    }
}
