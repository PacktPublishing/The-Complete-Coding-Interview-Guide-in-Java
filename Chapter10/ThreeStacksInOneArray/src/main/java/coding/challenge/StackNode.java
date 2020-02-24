package coding.challenge;

public class StackNode {

    int value;
    int link;

    StackNode(int value, int link) {
        this.value = value;
        this.link = link;
    }

    @Override
    public String toString() {
        return value + "(link: " + link + ")";
    }

}
