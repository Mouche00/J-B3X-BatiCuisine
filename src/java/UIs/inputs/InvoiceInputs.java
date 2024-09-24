package UIs.inputs;

import models.Invoice;
import utils.Parser;
import utils.Validator;
import utils.enums.InputType;

import java.time.LocalDate;

public class InvoiceInputs {
    public Invoice create() {
        LocalDate issuedAt, validatedAt;
        do {
            issuedAt = Parser.parseDate(
                    Validator.validateInput("Enter issue date (yyyy-mm-dd): ", InputType.DATE));
        } while(issuedAt.isBefore(LocalDate.now()));

        do {
            validatedAt = Parser.parseDate(
                    Validator.validateInput("Enter validation date (yyyy-mm-dd): ", InputType.DATE));
        } while(validatedAt.isBefore(issuedAt));

        return new Invoice(issuedAt, validatedAt);
    }
}
