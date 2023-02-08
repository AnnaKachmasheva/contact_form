import {Link} from "react-router-dom";
import styles from './Navbar.module.scss'

export const Navbar = (props) => {

    // let navigate = useNavigate();

    const logout = () => {
        // AuthService.logout();
        // navigate('/');
        window.location.reload()
    }


    return (
        <div className={styles.menu}>
            <span>
                {props.user ? (
                        <>
                            <button className={'button-primary'}
                                    onClick={() => logout()}>
                                Logout
                            </button>
                        </>
                    )
                    :
                    <>
                        <Link to={'/login'}>
                            <button className={'button-primary lg'}>
                                SIGN IN
                            </button>
                        </Link>
                        <Link to={'/employee'}>
                            <button className={'button-primary lg'}>
                                REGISTRATION
                            </button>
                        </Link>
                    </>
                }
            </span>
        </div>
    );
}