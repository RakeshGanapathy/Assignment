package comcast.digital.assignment.lcs.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SetOfString {
	@NotNull
	private String value;
}
