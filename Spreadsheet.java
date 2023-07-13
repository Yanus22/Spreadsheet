public class Spreadsheet {
    private Cell[][] array;
    private int row = 0;
    private int colum = 0;

    Spreadsheet(int row, int colum) {
        this.row = row;
        this.colum = colum;
        this.array = new Cell[row][colum];
    }

    public void addColum(int position) {
        if(position <=0 || position - this.colum > 2) {
            System.out.println("cheq kara et dirqum evalecaneq vorovhetev durseq ekel  taracqic");
            return;
        }
        Cell[][] resultArr = new Cell[this.row][this.colum + 1];
        if(position == 1) {
            for (int i = 0; i < this.row; i++) {
                resultArr[i][0] = new Cell();
                for (int j = 1; j <= this.colum; j++)
                    resultArr[i][j] = this.array[i][j - 1];
            }
            this.array = resultArr;
            this.colum++;
            return;
        }
        else if(position == this.colum){
            for(int i = 0; i < this.row; i++){
                for(int j = 0; j < this.colum;j++)
                    resultArr[i][j] = this.array[i][j];
                resultArr[i][position] = new Cell();
            }
            this.array = resultArr;
            this.colum++;
            return;
        }
        else{
            for(int i = 0 ;i < this.row;i++){
                for(int j = 0;j <= this.colum;j++){
                    if(j == position)
                        resultArr[i][j] = new Cell();
                    else if (j < position)
                        resultArr[i][j] = this.array[i][j];
                    else resultArr[i][j] = this.array[i][j-1];
                }
            }
            this.array = resultArr;
            this.colum++;
            return;
        }
    }
    public void addRow(int position) {
        if (position < 0 || position - this.row > 2) {
            System.out.println("cheq kara avelacneq dirqic durseq ekel");
            return;
        }

        Cell[][] resultArr = new Cell[row + 1][colum];
        Cell[] arrRow = new Cell[this.colum];
        for (int i = 0; i < this.colum; i++)
            arrRow[i] = new Cell();
        if (position == 1) {
            resultArr[0] = arrRow;
            for (int i = 1 ; i <= row; i++)
                resultArr[i] = this.array[i-1];
            this.array = resultArr;
            this.row++;
            return;
        } else if (position == this.row) {
            resultArr[position] = arrRow;
            for(int i = 0; i < this.row;i++)
                resultArr[i] = this.array[i];
            this.array = resultArr;
            this.row++;
            return;
        }
        else {
            for(int i = 0; i <= this.row;i++){
                if(i < position)
                    resultArr[i] = this.array[i];
                else if (i == position)
                    resultArr[i] = arrRow;
                else
                    resultArr[i] = this.array[i-1];
            }
            this.array =resultArr;
            this.row++;
            return;
        }
    }

    public void setValue(int row, int colum, Object value) {
        Cell value1 = (Cell) value;
        if (/*(value instanceof String  || value instanceof Number || value instanceof LocalDateTime) && */row < this.row && colum < this.colum)
            this.array[row][colum] = (Cell) value;
        else System.out.println("ka anhamapatsxanutyun");
    }

    public Object getValue(int row, int colum) {
        if (this.array[row][colum] == null) {
            System.out.println("et dirq@ dataraka  ");
            return null;
        }
        if (row < this.row && colum < this.colum) return array[row][colum].getValue();
        System.out.println("indexneri xndir");
        return null;
    }

    public void setColor(int row, int colum, Color color) {
        if (row < this.row && colum < this.colum) this.array[row][colum].setColor(color);
        else System.out.println("ka anhamapatsxanutyun");
    }

    public Color getColor(int row, int colum) {
        if (row < this.row && colum < this.colum)
            return this.array[row][colum].getColor();
        else {
            System.out.println("ka");
            return null;
        }
    }

    public void reSet() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.colum; j++)
                this.array[i][j] = new Cell();
        }
    }

    public void reSetCell(int row, int colum) {
        if (row > this.row || colum > this.colum) {
            System.out.println("durs eq ekel taracqic");
            return;
        }

        this.array[row][colum] = new Cell();
    }

    public double getColumSum(int colum) {
        if (colum > this.colum) {
            System.out.println("sxal syun eq tvel");
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < this.row; i++) {
            if (this.array[i][colum].geType() == Type.NUMBER)
                sum += (Double) this.array[i][colum].getValue();
            else {
                System.out.println("ka cell vor valuen  tiv chi");
                return 0;
            }
        }
        return sum;
    }

    public double getRowSum(int row) {
        if (row > this.row) {
            System.out.println("durs es ekel taracqic");
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < this.colum; i++) {
            if (this.array[row][i].geType() == Type.NUMBER)
                sum += (double) this.array[row][i].getValue();
            else {
                System.out.println("ka cell vor type@ tiv chi");
                return 0;
            }
        }
        return sum;
    }

    public double getAreaSum(int startRow, int endRow, int startColum, int endColum) {
        if (startRow > this.row || endRow > this.row || startColum > this.colum || endColum > this.colum
                || startRow < 0 || startColum < 0 || endRow < 0 || endColum < 0) {
            System.out.println("sxal area eq tvel");
            return 0;
        }
        double sum = 0;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColum; j <= endColum; j++) {
                if (this.array[i][j].geType() == Type.NUMBER)
                    sum += (double) this.array[i][j].getValue();
                else {
                    System.out.println("ka cell vor type@ number chi");
                    return 0;
                }
            }
        }
        return sum;
    }

    public double getAverageColum(int colum) {
        return this.getColumSum(colum) / row;
    }

    public double getAverageRow(int row) {
        return this.getRowSum(row) / colum;
    }

    public double getAverageArea(int startRow, int endRow, int startColum, int endColum) {
        return this.getAreaSum(startRow, endRow, startColum, endColum) / (endRow - startRow) * (endColum - endColum);
    }

}