package Dvideos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class User {

    String name;
    String surname;
    String pwd;
    LocalDate register_date;
    List<Video> video_list;
   
    //Constructor
    public User (String name, String surname, String pwd, LocalDate register_date, List<Video> video_list) {
        this.name = name;
        this.surname = surname;
        this.pwd = pwd;
        this.register_date = register_date;
        this.video_list = video_list;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public LocalDate getRegister_date() {
        return register_date;
    }

    public void setRegister_date(LocalDate register_date) {
        this.register_date = register_date;
    }

    public List<Video> getVideo_list() {
        return video_list;
    }

    public void setVideo_list(List<Video> video_list) {
        this.video_list = video_list;
    }

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", pwd=" + pwd + ", register_date=" + register_date
				+ ", video_list=" + video_list + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((register_date == null) ? 0 : register_date.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((video_list == null) ? 0 : video_list.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (register_date == null) {
			if (other.register_date != null)
				return false;
		} else if (!register_date.equals(other.register_date))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (video_list == null) {
			if (other.video_list != null)
				return false;
		} else if (!video_list.equals(other.video_list))
			return false;
		return true;
	}    
}
