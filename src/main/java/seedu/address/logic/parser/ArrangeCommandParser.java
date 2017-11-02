package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.ArrangeCommand;
import seedu.address.logic.commands.ChangePasswordCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ChangePasswordCommand object
 */
public class ArrangeCommandParser implements Parser<ArrangeCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ArrangeCommand
     * and returns an ArrangeCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ArrangeCommand parse(String args) throws ParseException {

        try {
            String[] ListOfPerson = args.trim().split("\\s+");
            // Correct Format: changepw username old_password new_password
            int[] ListOfIndex = new int[ListOfPerson.length];
            for(int i = 0; i < ListOfPerson.length; i++) {
                try {
                    ListOfIndex[i] = Integer.parseInt(ListOfPerson[i]);
                }
                catch (NumberFormatException e){
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            ArrangeCommand.MESSAGE_USAGE));
                }
            }
            return new ArrangeCommand(ListOfIndex);
        }
        catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ChangePasswordCommand.MESSAGE_USAGE));
        }
    }
}