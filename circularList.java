public class circularList {

    private Turn actual;

    public int counter = 0;


    public circularList() {
        this.actual = null;
    }

    public boolean isEmpty() {
        return actual == null;
    }

    public void darTurno(){

        darTurno(new Turn(counter));
        counter++;

    }

    private void darTurno(Turn turn) {


        if (actual == null) {
            actual = turn;
            actual.setNext(turn);
            actual.setPrevious(actual);
        } else {
            Turn next = actual.getPrevious();
            turn.setNext(actual);
            actual.setPrevious(turn);
            next.setNext(turn);
            turn.setPrevious(next);
        }

    }

    public int getCurrentNum() {

        if (isEmpty()) {
            return -1;
        } else {
            return actual.getNext().getNumero();
        }
    }

    public void goToNext() {

        if (!isEmpty()) {

            Turn current = actual.getNext();

            if (counter == 1) {
                actual = null;
            } else {
                actual.setNext(current.getNext());
            }
            counter--;
        }
    }

    public void passTurn() {

        if (!isEmpty()) {

            Turn current = actual.getNext();
            int count = current.getQuantityPassed();
            count++;

            if (count > 3) {
                System.out.println("El turno " + current.getNumero()+ " no se presentó, por lo cual no será llamado mas");

                goToNext();

            }else{actual = current;}

        }
    }

    public void printAll(){
        if(actual == null){
            System.out.println("Nadie ha solicitado un turno aun ");
        }else{
            printAll(actual);
        }
    }

    private void printAll(Turn current){
        if(current == actual.getPrevious()){
            System.out.println(current.getNumero());
            return;
        }
        System.out.println(current.getNumero());
        printAll(current.getNext());
    }


    private void delete(Turn current, int attended){

        if(current.getNumero()==attended){

            if(current == actual){
                actual.getPrevious().setNext(actual.getNext());
                actual.getNext().setPrevious(actual.getPrevious());
                actual = actual.getNext();
            }else{
                Turn prev = current.getPrevious();
                Turn next = current.getNext();
                prev.setNext(next);
                next.setPrevious(prev);
            }
            return;
        }
        if(current.getNext() == actual){
            return;
        }
        delete(current.getNext(),attended);

    }

    public void delete(int attended){

        if(actual == null){
            System.out.println("Nadie ha sido atendido");
        }else{
            delete(actual, attended);
        }
    }
}
