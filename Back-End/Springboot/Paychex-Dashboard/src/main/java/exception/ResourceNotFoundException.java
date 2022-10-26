package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Ryan Woodward
 * Institution:    | Grand Canyon University & Paychex
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-26-2022
 * File:           | ResourceNotFoundExcpetion.java
 * Version:        | 1.0
 * Description:    | This file will be used to handle error related to null
 *                 | entities queried from the PaychexDashboard database
 * ---------------------------------------------------------------------------
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    private static final Long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }

}//ResourceNotFoundException Class
