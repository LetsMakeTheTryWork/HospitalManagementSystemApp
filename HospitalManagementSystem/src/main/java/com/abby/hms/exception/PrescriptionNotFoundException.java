//package com.abby.hms.exception;
//
//public class PrescriptionNotFoundException {
//}
package com.abby.hms.exception;

public class PrescriptionNotFoundException extends RuntimeException {
    public PrescriptionNotFoundException(String message) {
        super(message);
    }
}



