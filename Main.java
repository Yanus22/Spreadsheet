import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Cell[] arr1 = {new Cell(), new Cell(55, null, Type.NUMBER)};
        Cell[] arr2 = {new Cell(), new Cell(555, null, Type.NUMBER)};
        Cell[] arr3 = {new Cell("hello", null, Type.STRING), new Cell(-8, null, Type.NUMBER)};
        Spreadsheet spreadsheet = new Spreadsheet(3, 2);
        spreadsheet.setValue(0, 0, arr1[0]);
        spreadsheet.setValue(0, 1, arr1[1]);
        spreadsheet.setValue(1, 0, arr2[0]);
        spreadsheet.setValue(1, 1, arr2[1]);
        spreadsheet.setValue(2, 0, arr3[0]);
        spreadsheet.setValue(2, 1, arr3[1]);
     //   spreadsheet.addRow(2);
        spreadsheet.addColum(1);
    }
}

