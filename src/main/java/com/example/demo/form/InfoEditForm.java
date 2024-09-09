package com.example.demo.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InfoEditForm {
	
	@NotNull(message="適切な値を選択してください")
	private Integer id;
	
	@NotEmpty(message="入力されていません。変更を実行しない場合も、既存の値を記入してください")
	@Size(min = 1, max=80, message="1~80文字で入力してください")
	private String name;
	
	@NotNull(message="入力されていません。変更を実行しない場合も、既存の値を記入してください")
	private Integer genre;
	
	@NotNull(message="入力されていません。変更を実行しない場合も、既存の値を記入してください")
	private Integer area;
	
	private boolean haltFlag;
	
	private boolean myRecommend;
	
	private boolean today;

}
