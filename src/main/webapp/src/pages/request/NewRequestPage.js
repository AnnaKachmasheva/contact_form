import {useFormik} from "formik";
import {useEffect, useState} from "react";
import axios from "axios";
import {Navbar} from "../parts/Navbar";

function NewRequestPage() {

    const [lengthRequest, setLengthRequest] = useState(0);
    const [selectedKindOfRequest, setSelectedKindOfRequest] = useState(null);

    const validate = values => {
        const errors = {};

        setLengthRequest(values.description.length);

        if (!values.policyNumber.match(/^[0-9a-zA-Z]+$/)) {
            errors.policyNumber = 'Invalid characters.';
        }

        if (!values.name.match(/^[a-zA-Z]+$/)) {
            errors.name = 'Invalid characters.';
        }

        if (!values.surname.match(/^[a-zA-Z]+$/)) {
            errors.surname = 'Invalid characters.';
        }

        if (lengthRequest  > 5000) {
            errors.description = 'Max length description request 5000';
        }

        return errors;
    };

    const kindOfRequestSelect = (e) => {
        setSelectedKindOfRequest(e.target.value);
    }

    const formik = useFormik({
        initialValues: {
            kindOfRequest: "",
            policyNumber: "",
            name: "",
            surname: "",
            description: "",
        },
        validate,
        onSubmit: values => {

            values.kindOfRequest = selectedKindOfRequest;

            axios.post(`http://localhost:8080/`,
                {
                    "description": values.description,
                    "kindOfRequest": values.kindOfRequest,
                    "name": values.name,
                    "policyNumber": values.policyNumber,
                    "surname": values.surname
                })
                .then((response) => {
                    console.log(response);
                    window.location.reload();
                });
        }
    });

    const [optionsKindOfRequest, setOptionsKindOfRequest] = useState([]);

    useEffect(() => {
        const kindOfRequest = async () => {

            const options = await Promise.any([
                axios.get('http://localhost:8080/')]);

            setOptionsKindOfRequest(options.data);
        }

        // Call the function
        kindOfRequest();
    }, []);


    return (
        <div>
            <div>
                <Navbar />
            </div>
            <div className="window">
                <div onClick={(e) => e.stopPropagation()}
                     className="container">

                    <div className="modal-header">
                        <h1>Contact us</h1>
                    </div>

                    <form className="modal-form"
                          onSubmit={formik.handleSubmit}>

                        <div>
                            <label htmlFor="kindOfRequest">Kind of Request</label>
                            <select id="kindOfRequest"
                                    defaultChecked={optionsKindOfRequest[0]}
                                    onChange={kindOfRequestSelect}>
                                {optionsKindOfRequest.map((option) => (
                                    <option value={option}>
                                        {option}
                                    </option>
                                ))}
                            </select>

                            <label htmlFor="policyNumber">Policy Number</label>
                            <input id="policyNumber"
                                   className={formik.errors.policyNumber ? "error-input" : "success-input"}
                                   onChange={formik.handleChange}
                                   onBlur={formik.handleBlur}
                                   value={formik.values.policyNumber}
                            />
                            {formik.errors.policyNumber ? <div className="error">{formik.errors.policyNumber}</div> : null}

                            <label htmlFor="name">Name</label>
                            <input id="name"
                                   className={formik.errors.name ? "error-input" : "success-input"}
                                   onChange={formik.handleChange}
                                   onBlur={formik.handleBlur}
                                   value={formik.values.name}
                            />
                            {formik.errors.name ? <div className="error">{formik.errors.name}</div> : null}

                            <label htmlFor="surname">Surname</label>
                            <input id="surname"
                                   className={formik.errors.surname ? "error-input" : "success-input"}
                                   onChange={formik.handleChange}
                                   onBlur={formik.handleBlur}
                                   value={formik.values.surname}
                            />
                            {formik.errors.surname ? <div className="error">{formik.errors.surname}</div> : null}

                            <label htmlFor="description">Your request</label>
                            <textarea id="description"
                                      className={formik.errors.description ? "error-input" : "success-input"}
                                      onChange={formik.handleChange}
                                      onBlur={formik.handleBlur}
                                      value={formik.values.description}
                                      maxLength={5000}
                            >
                        </textarea>
                            {formik.errors.description ? <div className="error-input">{formik.errors.description}</div> : null}

                            <p>{lengthRequest}/5000</p>

                        </div>

                        <div className="button-form">
                            <button className="send-button"
                                    type="submit">
                                <span>SEND REQUEST</span>
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    )
}

export default NewRequestPage;