import {useFormik} from "formik";
import {useEffect, useState} from "react";
import axios from "axios";
import {Navbar} from "../parts/Navbar";
import styles from './NewRequestPage.module.scss'
import {baseUrl} from "../../config/const";

function NewRequestPage() {

    const [lengthRequest, setLengthRequest] = useState(0);
    const [selectedKindOfRequest, setSelectedKindOfRequest] = useState(null);

    const validate = values => {
        const errors = {};

        setLengthRequest(values.description.length);

        if (values.policyNumber.length === 0) {
            errors.policyNumber = 'This field is required.';
        } else if (!values.policyNumber.match(/^[0-9a-zA-Z]+$/)) {
            errors.policyNumber = 'Invalid characters. The policy number must be composed of numbers and letters.';
        }

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

        if (lengthRequest  > 5000) {
            errors.description = 'Maximum description length 5000 characters.';
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
            description: ""
        },
        validate,
        onSubmit: values => {

            values.kindOfRequest = selectedKindOfRequest;

            axios.post(`${baseUrl}/contactus`,
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
                axios.get('${baseUrl}/contactus')]);

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
                     className={styles.container}>

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

                            <label htmlFor="policyNumber">Policy Number*</label>
                            <input id="policyNumber"
                                   className={formik.errors.policyNumber ? "input-primary error" : "input-primary correct"}
                                   onChange={formik.handleChange}
                                   onBlur={formik.handleBlur}
                                   placeholder={'1998num74'}
                                   value={formik.values.policyNumber}
                            />
                            {formik.errors.policyNumber ? <div className="error">{formik.errors.policyNumber}</div> : null}

                            <label htmlFor="name">Name*</label>
                            <input id="name"
                                   className={formik.errors.name ? "input-primary error" : "input-primary correct"}
                                   onChange={formik.handleChange}
                                   onBlur={formik.handleBlur}
                                   placeholder={'James'}
                                   value={formik.values.name}
                            />
                            {formik.errors.name ? <div className="error">{formik.errors.name}</div> : null}

                            <label htmlFor="surname">Surname*</label>
                            <input id="surname"
                                   className={formik.errors.surname ? "input-primary error" : "input-primary correct"}
                                   onChange={formik.handleChange}
                                   onBlur={formik.handleBlur}
                                   placeholder={'Smith'}
                                   value={formik.values.surname}
                            />
                            {formik.errors.surname ? <div className="error">{formik.errors.surname}</div> : null}

                            <label htmlFor="description">Your request</label>
                            <textarea id="description"
                                      className={formik.errors.description ? "input-primary error" : "input-primary correct"}
                                      onChange={formik.handleChange}
                                      onBlur={formik.handleBlur}
                                      value={formik.values.description}
                                      maxLength={5000}
                            >
                        </textarea>
                            {formik.errors.description ? <div className="error">{formik.errors.description}</div> : null}

                            <p>{lengthRequest}/5000</p>

                        </div>

                        <div className="button-form">
                            <button className="button-primary"
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