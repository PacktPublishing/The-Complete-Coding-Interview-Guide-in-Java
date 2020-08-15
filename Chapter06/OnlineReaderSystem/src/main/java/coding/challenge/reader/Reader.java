package coding.challenge.reader;
 
import java.util.Objects;

public class Reader {
    
    private String name;
    private String email;

    public Reader(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Reader other = (Reader) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        
        return true;
    }
        
}
