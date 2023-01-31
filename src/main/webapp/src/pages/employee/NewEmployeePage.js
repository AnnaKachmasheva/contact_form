import {useFormik} from "formik";
import {useState} from "react";
import axios from "axios";

function NewRequestPage() {

    const [lengthRequest, setLengthRequest] = useState(0);
    const [selectedKindOfRequest, setSelectedKindOfRequest] = useState(null);

    const validate = values => {
        const errors = {};

        setLengthRequest(values.description.length);

        if (!values.name.match(/^[a-zA-Z]+$/)) {
            errors.name = 'Invalid characters.';
        }

        if (!values.surname.match(/^[a-zA-Z]+$/)) {
            errors.surname = 'Invalid characters.';
        }

        //todo
        if (!values.surname.match(/^[a-zA-Z]+$/)) {
            errors.surname = 'Invalid characters.';
        }

        if (lengthRequest > 5000) {
            errors.description = 'Max length description request 5000';
        }

        return errors;
    };

    const kindOfRequestSelect = (e) => {
        setSelectedKindOfRequest(e.target.value);
    }

    const formik = useFormik({
        initialValues: {
            name: "",
            surname: "",
            dateOfBirth: "",
            gender: "",
            position: "",
            email: "",
            phone: "",
            password: "",
            passwordConfirm: "",
            state: "",
            city: "0",
            street: "",
            postal: "",
            addresses: []
        },
        validate,
        onSubmit: values => {

            values.kindOfRequest = selectedKindOfRequest;

            axios.post(`http://localhost:8080/employee`,
                {
                    "name": values.name,
                    "surname": values.surname,
                    "dateOfBirth": values.dateOfBirth,
                    "gender": values.gender,
                    "position": values.position,
                    "email": values.email,
                    "phone": values.phone,
                    "password": values.password,
                    "passwordConfirm": values.passwordConfirm,
                    "addresses": values.addresses
                })
                .then((response) => {
                    console.log(response);
                    window.location.reload();
                });
        }
    });

    const genderOptions = [
        {
            label: "Female",
            value: 1
        },
        {
            label: "Male",
            value: 2
        },
        {
            label: "Transgender female",
            value: 3
        },
        {
            label: "Transgender male",
            value: 4
        },
        {
            label: "Prefer not the answer",
            value: 5
        },
        {
            label: "Not listed",
            value: 6
        }
    ];

    const heading = ['state', 'city', 'postal', 'street'];

    return (
        <div className="window">

            <div onClick={(e) => e.stopPropagation()}
                 className="registration">

                <div className="modal-header">
                    <h1>Registration</h1>
                </div>

                <form className="modal-form"
                      onSubmit={formik.handleSubmit}>
                    <div>
                        <label htmlFor="name">Name</label>
                        <input id="name"
                               className={formik.errors.name ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.name}
                               placeholder={"Jan"}
                        />
                        {formik.errors.name ? <div className="error">{formik.errors.name}</div> : null}

                        <label htmlFor="surname">Surname</label>
                        <input id="surname"
                               className={formik.errors.surname ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.surname}
                               placeholder={"Baer"}
                        />
                        {formik.errors.surname ? <div className="error">{formik.errors.surname}</div> : null}

                        <label htmlFor="dateOfBirth">Date of Birth</label>
                        <input id="dateOfBirth"
                               className={formik.errors.dateOfBirth ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.dateOfBirth}
                               type={"date"}
                        />
                        {formik.errors.dateOfBirth ? <div className="error">{formik.errors.dateOfBirth}</div> : null}

                        <label htmlFor="gender">Gender</label>
                        <select id="gender"
                                defaultChecked={genderOptions[0]}
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}>
                            {genderOptions.map((option) => (
                                <option value={option.label}>
                                    {option.label}
                                </option>
                            ))}
                        </select>
                        {formik.errors.gender ? <div className="error">{formik.errors.gender}</div> : null}

                        <label htmlFor="position">Position</label>
                        <input id="position"
                               className={formik.errors.position ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.position}
                               placeholder={"Manager"}
                        />
                        {formik.errors.position ? <div className="error">{formik.errors.position}</div> : null}

                        <label htmlFor="email">Email</label>
                        <input id="email"
                               className={formik.errors.email ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.email}
                               type={"email"}
                               placeholder={"mail@gmail.com"}
                        />
                        {formik.errors.email ? <div className="error">{formik.errors.email}</div> : null}

                        <label htmlFor="phone">Phone</label>
                        <input id="phone"
                               className={formik.errors.phone ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.phone}
                               type={"text"}
                               placeholder={"1234567"}
                        />
                        {formik.errors.phone ? <div className="error">{formik.errors.phone}</div> : null}

                        <label htmlFor="password">Password</label>
                        <input id="password"
                               className={formik.errors.password ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.password}
                               type={"password"}
                               placeholder={"*****"}
                        />
                        {formik.errors.password ? <div className="error">{formik.errors.password}</div> : null}

                        <label htmlFor="passwordConfirm">Confirm password</label>
                        <input id="passwordConfirm"
                               className={formik.errors.password ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.passwordConfirm}
                               type={"password"}
                               placeholder={"*****"}
                        />
                        {formik.errors.passwordConfirm ?
                            <div className="error">{formik.errors.passwordConfirm}</div> : null}
                    </div>

                    <div>
                        <table>
                            <thead>
                            <tr>
                                {heading.map(head => <th>{head}</th>)}
                            </tr>
                            </thead>
                            <tbody>
                            {/*{body.map(row => <TableRow row={row}/>)}*/}
                            </tbody>
                        </table>

                        <label htmlFor="state">State</label>
                        <input id="state"
                               className={formik.errors.state ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.state}
                               placeholder={"CR"}
                        />
                        {formik.errors.state ? <div className="error">{formik.errors.state}</div> : null}

                        <label htmlFor="city">City</label>
                        <input id="city"
                               className={formik.errors.city ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.city}
                               placeholder={"Prague"}
                        />
                        {formik.errors.city ? <div className="error">{formik.errors.city}</div> : null}

                        <label htmlFor="street">Street</label>
                        <input id="street"
                               className={formik.errors.street ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.street}
                               placeholder={""}
                        />
                        {formik.errors.street ? <div className="error">{formik.errors.street}</div> : null}

                        <label htmlFor="postal">Postal</label>
                        <input id="postal"
                               className={formik.errors.postal ? "error-input" : "success-input"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.postal}
                               placeholder={""}
                        />
                        {formik.errors.postal ? <div className="error">{formik.errors.postal}</div> : null}

                        {/*<div className="button-form">*/}
                        {/*    <button className="send-button"*/}
                        {/*            type="submit">*/}
                        {/*        <span>ADD ADDRESS</span>*/}
                        {/*    </button>*/}
                        {/*</div>*/}

                        <div className="button-form">
                            <button className="send-button"
                                    type="submit">
                                <span>CREATE EMPLOYEE</span>
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default NewRequestPage;