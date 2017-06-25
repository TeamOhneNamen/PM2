/**
 * EmptyStackException.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P06;

public class EmptyStackException extends Exception
{

	private static final long serialVersionUID = 1L;

	public EmptyStackException()
    {
        super("The stack is empty");
    }
}

