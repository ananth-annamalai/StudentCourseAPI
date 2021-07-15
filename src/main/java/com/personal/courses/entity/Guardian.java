package com.personal.courses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name="name",
                column=@Column(name="guardian_name")),
        @AttributeOverride(name="email",
                column=@Column(name="guardian_email")),
        @AttributeOverride(name="mobile",
                column=@Column(name="guardian_mobile"))
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
