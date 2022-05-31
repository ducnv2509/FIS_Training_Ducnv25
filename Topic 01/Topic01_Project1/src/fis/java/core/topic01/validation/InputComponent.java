package fis.java.core.topic01.validation;

public class InputComponent implements IValidation {
    private IValidation validation;
    private String data;

    public void setData(String data) {
        this.data = data;
    }
    public void display(){

    }

    public void setValidation(IValidation validation) {
        this.validation = validation;
    }

    @Override
    public boolean validate(String data) {
        return false;
    }
}
