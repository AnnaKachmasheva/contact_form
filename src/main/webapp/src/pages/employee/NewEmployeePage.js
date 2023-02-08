import {useFormik} from "formik";
import axios from "axios";
import styles from './NewEmployeePage.module.scss'
import {Link} from "react-router-dom";


function NewRequestPage() {


    const validate = values => {
        const errors = {};

        if (values.name.length === 0) {
            errors.name = 'This field is required.';
        } else if (!values.name.match(/^[a-zA-Z]+$/)) {
            errors.name = 'Invalid characters. The name must contain letters.';
        }

        if (values.surname.length === 0) {
            errors.surname = 'This field is required.';
        } else if (!values.surname.match(/^[a-zA-Z]+$/)) {
            errors.surname = 'Invalid characters. The surname must contain letters.';
        }

        if (!values.email.match(/^\S+@\S+\.\S+$/)) {
            errors.email = 'Invalid email.';
        }

        if (values.position.length === 0) {
            errors.position = 'This field is required.';
        }

        if (values.phone.length === 0) {
            errors.phone = 'This field is required.';
        } else if (!values.phone.match(/^\d{9}$/g)) {
            errors.phone = 'Invalid phone number.';
        }

        if (values.password.length === 0) {
            errors.password = 'This field is required.';
        } else if (values.password.length < 5) {
            errors.password = 'Invalid password. Password length must be at least 5 characters.';
        }

        if (values.passwordConfirm.length === 0) {
            errors.passwordConfirm = 'This field is required.';
        } else if (values.password !== values.passwordConfirm) {
            errors.passwordConfirm = 'Password mismatch.';
        }

        if ((values.state !== "") && !values.state.match(/^[a-zA-Z]+$/)) {
            errors.state = 'Invalid characters. The state must contain letters.';
        }

        if ((values.city !== "") && !values.city.match(/^[a-zA-Z]+$/)) {
            errors.city = 'Invalid characters. The city must contain letters.';
        }

        if ((values.street !== "") && !values.street.match(/^[a-zA-Z1-9]+$/)) {
            errors.street = 'Invalid characters. The street must contain letters or numbers.';
        }

        if ((values.postal !== "") && !values.postal.match(/^[1-9]{5}$/)) {
            errors.postal = 'Invalid characters. The postal must contain 5 numbers.';
        }

        return errors;
    };

    function contollAddAddress() {
        //TODO add address to addressses
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
            city: "",
            street: "",
            postal: "",
            address: [],
            addresses: []
        },
        validate,
        onSubmit: values => {

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
                 className={styles.container}>

                <div className="modal-header">
                    <h1>Registration</h1>
                </div>

                <form className="modal-form"
                      onSubmit={formik.handleSubmit}>
                    <div className={styles.form}>
                        <label htmlFor="name">Name*</label>
                        <input id="name"
                               className={formik.errors.name ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.name}
                               placeholder={"Jan"}
                        />
                        {formik.errors.name ? <div className="error">{formik.errors.name}</div> : null}

                        <label htmlFor="surname">Surname*</label>
                        <input id="surname"
                               className={formik.errors.surname ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.surname}
                               placeholder={"Baer"}
                        />
                        {formik.errors.surname ? <div className="error">{formik.errors.surname}</div> : null}

                        <label htmlFor="dateOfBirth">Date of Birth*</label>
                        <input id="dateOfBirth"
                               className={formik.errors.dateOfBirth ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.dateOfBirth}
                               type={"date"}
                        />
                        {formik.errors.dateOfBirth ? <div className="error">{formik.errors.dateOfBirth}</div> : null}

                        <label htmlFor="gender">Gender*</label>
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

                        <label htmlFor="position">Position*</label>
                        <input id="position"
                               className={formik.errors.position ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.position}
                               placeholder={"Manager"}
                        />
                        {formik.errors.position ? <div className="error">{formik.errors.position}</div> : null}

                        <label htmlFor="email">Email*</label>
                        <input id="email"
                               className={formik.errors.email ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.email}
                               type={"email"}
                               placeholder={"mail@gmail.com"}
                        />
                        {formik.errors.email ? <div className="error">{formik.errors.email}</div> : null}

                        <label htmlFor="phone">Phone*</label>
                        <input id="phone"
                               className={formik.errors.phone ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.phone}
                               type={"text"}
                               placeholder={"1234567"}
                        />
                        {formik.errors.phone ? <div className="error">{formik.errors.phone}</div> : null}

                        <label htmlFor="password">Password*</label>
                        <input id="password"
                               className={formik.errors.password ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.password}
                               type={"password"}
                               placeholder={"*****"}
                        />
                        {formik.errors.password ? <div className="error">{formik.errors.password}</div> : null}

                        <label htmlFor="passwordConfirm">Confirm password*</label>
                        <input id="passwordConfirm"
                               className={formik.errors.passwordConfirm ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.passwordConfirm}
                               type={"password"}
                               placeholder={"*****"}
                        />
                        {formik.errors.passwordConfirm ?
                            <div className="error">{formik.errors.passwordConfirm}</div> : null}
                    </div>

                    <div className={styles.address}>
                        <table>
                            <thead>
                            <tr>
                                {heading.map(head => <th>{head}</th>)}
                            </tr>
                            </thead>
                            <tbody>
                            {
                                formik.values.addresses.map(address => address.map(pol => <td>{pol}</td>))
                            }
                            </tbody>
                        </table>

                        <label htmlFor="state">State</label>
                        <input id="state"
                               className={formik.errors.state ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.state}
                               placeholder={"CR"}
                        />
                        {formik.errors.state ? <div className="error">{formik.errors.state}</div> : null}

                        <label htmlFor="city">City</label>
                        <input id="city"
                               className={formik.errors.city ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.city}
                               placeholder={"Prague"}
                        />
                        {formik.errors.city ? <div className="error">{formik.errors.city}</div> : null}

                        <label htmlFor="street">Street</label>
                        <input id="street"
                               className={formik.errors.street ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.street}
                               placeholder={"street"}
                        />
                        {formik.errors.street ? <div className="error">{formik.errors.street}</div> : null}

                        <label htmlFor="postal">Postal</label>
                        <input id="postal"
                               className={formik.errors.postal ? "input-primary error" : "input-primary correct"}
                               onChange={formik.handleChange}
                               onBlur={formik.handleBlur}
                               value={formik.values.postal}
                               placeholder={"19500"}
                        />
                        {formik.errors.postal ? <div className="error">{formik.errors.postal}</div> : null}
                        <button className="button-primary"
                                onClick={contollAddAddress}>
                            <span>ADD ADDRESS</span>
                        </button>
                    </div>
                    <button className="button-primary"
                            type="submit">
                        <span>CREATE EMPLOYEE</span>
                    </button>


                    <Link className={'registration-link'}
                          to={'/login'}>
                        SIGN IN
                    </Link>
                </form>
            </div>
        </div>
    )
}

export default NewRequestPage;