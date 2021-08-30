package comcast.digital.assignment.lcs.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Valid
public class LCSRequest {
	private @NotNull List<SetOfString> setOfStrings = new ArrayList<SetOfString>();
}
