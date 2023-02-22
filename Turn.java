public class Turn {
        private int numero;
        private Turn next;

        private Turn previous;
        private int quantityPassed;

    public int getQuantityPassed() {
        return quantityPassed;
    }

    public void setQuantityPassed(int quantityPassed) {
        this.quantityPassed = quantityPassed;
    }

    public Turn(int numero) {
            this.numero = numero;
            this.next = null;
            this.quantityPassed = 0;
        }

        public int getNumero() {
            return numero;
        }

        public void setName(int numero) {
            this.numero = numero;
        }

        public Turn getNext() {
            return next;
        }

        public void setNext(Turn next) {
            this.next = next;
        }

        public Turn getPrevious() {
            return previous;
        }

        public void setPrevious(Turn previous) {
            this.previous = previous;
        }
}

