import java.time.LocalDate;

public class Cell {
    private Object value;
    private Color color = Color.WHITE;
    private Type type;

    Cell(Object value, Color color, Type type) {
        boolean instanceOfString = value instanceof String;
        boolean instanceOfNumber = value instanceof Number;
        boolean instanceOfdate = value instanceof LocalDate;
        if (instanceOfString || instanceOfdate || instanceOfNumber) {
            if (instanceOfString) {
                if (type != Type.STRING)
                    System.out.println("stringi het cheq kara urish type taq");
                this.type = Type.STRING;
                this.value = value;
            } else if (instanceOfdate) {
                if (type != Type.DATE)
                    System.out.println("datei het sxal typeq tvel");
                this.type = Type.DATE;
                this.value = value;

            } else if (instanceOfNumber) {
                if (type != Type.NUMBER)
                    System.out.println("sxal typeq tvel numberi het");
                this.type = Type.NUMBER;
                this.value = value;
            }
            this.color = color == null ? Color.WHITE : color;
        } else {
            System.out.println("duq tveleq sxal tipi obyekt ksarqvi deafult@");
            this.value = 0;
            this.type = Type.NUMBER;
            this.color = Color.WHITE;
        }
    }

    Cell() {
        this.value = 0;
        this.type = Type.NUMBER;
        this.color = Color.WHITE;
    }
    public void setType(Type t){
        this.type = type;
    }
    public void setValue(Object value) {
        if (value instanceof String || value instanceof Number || value instanceof LocalDate) this.value = value;
        else {
            System.out.println("ka anhamapatasxanutyun obyektneri tiperi ");
        }
    }

    public Object getValue() {
        if (this.type == Type.NUMBER) return Double.valueOf(this.value.toString());
        if (this.type == Type.STRING) return this.value.toString();
        else return (LocalDate) this.value;


    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public Type geType() {
        return this.type;
    }

    public void reSet() {
        this.color = Color.WHITE;
        this.value = 0;
        this.type = Type.NUMBER;
    }

}
