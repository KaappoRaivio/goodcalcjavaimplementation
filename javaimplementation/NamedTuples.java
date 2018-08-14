public class NamedTuples {
    public static class ExprSlice {
        private String content;
        private int startPos;
        private int endPos;



        public ExprSlice (String content, int startPos, int endPos) {
            this.content = content;
            this.startPos = startPos;
            this.endPos = endPos;
        }

        public int getStartPos() {
            return startPos;
        }

        public void setStartPos(int startPos) {
            this.startPos = startPos;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getEndPos() {
            return endPos;
        }

        public void setEndPos(int endPos) {
            this.endPos = endPos;
        }

        @Override
        public String toString() {
            return "ExprSlice{" +
                    "content='" + content + '\'' +
                    ", startPos=" + startPos +
                    ", endPos=" + endPos +
                    '}';
        }
    }

    public static class Calculation {
        private String leftOperand;
        private String operation;

        public String getLeftOperand() {
            return leftOperand;
        }

        public void setLeftOperand(String leftOperand) {
            this.leftOperand = leftOperand;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public String getRightOperand() {
            return rightOperand;
        }

        public void setRightOperand(String rightOperand) {
            this.rightOperand = rightOperand;
        }

        public String getLeftBoundary() {
            return leftBoundary;
        }

        public void setLeftBoundary(String leftBoundary) {
            this.leftBoundary = leftBoundary;
        }

        public String getRightBoundary() {
            return rightBoundary;
        }

        public void setRightBoundary(String rightBoundary) {
            this.rightBoundary = rightBoundary;
        }

        private String rightOperand;
        private String leftBoundary;
        private String rightBoundary;

        public Calculation (String leftOperand, String operation, String rightOperand, String leftBoundary, String rightBoundary) {
            this.leftOperand = leftOperand;
            this.operation = operation;
            this.rightOperand = rightOperand;
            this.leftBoundary = leftBoundary;
            this.rightBoundary = rightBoundary;
        }

    }
}
