package ch.rasc.mycustomer.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;

@JsonInclude(Include.NON_NULL)
public class ValidationErrorsResult<T> extends ExtDirectStoreResult<T> {
	private List<ValidationErrors> validations;

	public ValidationErrorsResult(T record) {
		super(record);
	}

	public ValidationErrorsResult(T record, List<ValidationErrors> validations) {
		super(record);
		setValidations(validations);
	}

	public List<ValidationErrors> getValidations() {
		return this.validations;
	}

	public void setValidations(List<ValidationErrors> validations) {
		this.validations = validations;
		if (this.validations != null && !this.validations.isEmpty()) {
			setSuccess(Boolean.FALSE);
		}
	}

}
