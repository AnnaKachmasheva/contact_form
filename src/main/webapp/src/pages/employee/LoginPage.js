import {useFormik} from "formik";
import {useState} from "react";
import axios from "axios";
import styles from './LoginPage.module.scss'


function LoginPage() {

    const validate = values => {
        const errors = {};

        if (!values.email.match(/^\S+@\S+\.\S+$/)) {
            errors.email = 'Invalid email.';
        }

        if (values.password.length < 5) {
            errors.password = 'Invalid password. Password length must be at least 5 characters.';
        }

        return errors;
    };

    const formik = useFormik({
        initialValues: {
            email: "",
            password: ""
        },
        validate,
        onSubmit: values => {
            axios.post(`http://localhost:8080/employee/login`,
                {
                    "email": values.email,
                    "password": values.password
                })
                .then((response) => {
                    console.log(response);
                    window.location.reload();
                });
        }
    });

    return (
        <div className="window">

            <div onClick={(e) => e.stopPropagation()}
                 className={styles.container}>

                <div className="modal-header">
                    <h1>Sign in</h1>
                </div>

                <form className="modal-form"
                      onSubmit={formik.handleSubmit}>

                    <label htmlFor="email">Email*</label>
                    <input id="email"
                           className={formik.errors.email ? "input-primary error" : "input-primary correct"}
                           onChange={formik.handleChange}
                           onBlur={formik.handleBlur}
                           value={formik.values.email}
                           type={"email"}
                           placeholder={"smith@gmail.com"}
                    />
                    {formik.errors.email ? <div className="error">{formik.errors.email}</div> : null}


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

                    <button className="button-primary"
                            type="submit">
                        <span>CONTUNE</span>
                    </button>

                    <a className="registration-link"
                       href="http://localhost:3000/employee">
                        REGISTRATION
                    </a>

                </form>
            </div>
        </div>
    )
}

export default LoginPage;