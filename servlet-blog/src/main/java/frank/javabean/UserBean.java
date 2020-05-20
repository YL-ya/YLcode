package frank.javabean;

//javaBean 本来是用来可视化、非可视化编程的
//将用户信息封装到javabean中去
public class UserBean {
    private String username;
    private String password;
    public void setUsername(String username){
        this.username=username;
    }
    public String  getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
