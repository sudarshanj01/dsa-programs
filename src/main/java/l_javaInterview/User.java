package l_javaInterview;

public class User {
    private String name;
    private int age;
    private String email;

    private User(UserBuilder userBuilder){
        this.name = userBuilder.name;
        this.age = userBuilder.age;
        this.email = userBuilder.email;
    }

    @Override
    public String toString() {
        return "javaInterview.User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public static class UserBuilder{
        private String name;
        private int age;
        private String email;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }

}