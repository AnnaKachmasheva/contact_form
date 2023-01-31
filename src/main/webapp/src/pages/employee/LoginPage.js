import {useFormik} from "formik";
import {useState} from "react";
import axios from "axios";

function LoginPage() {

    const [lengthRequest, setLengthRequest] = useState(0);
    const [selectedKindOfRequest, setSelectedKindOfRequest] = useState(null);

    const validate = values => {
        const errors = {};

        setLengthRequest(values.description.length);

        if (!values.email.match(/^[a-zA-Z]+$/)) {
            errors.email = 'Invalid email.';
        }

        if (values.password.length <= 5) {
            errors.password = 'Invalid password.';
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

            values.kindOfRequest = selectedKindOfRequest;

            axios.post(`http://localhost:8080/login`,
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
                 className="container">

                <div className="modal-header">
                    <h1>Sign in</h1>
                </div>

                <form className="modal-form"
                      onSubmit={formik.handleSubmit}>

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

                    <div className="button-form">
                        <a className="registration-link"
                           href="http://localhost:3000/employee">
                            Registration
                        </a>

                        <button className="send-button"
                                type="submit">
                            <span>CONTUNE</span>
                        </button>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default LoginPage;