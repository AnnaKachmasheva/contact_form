import {Link} from "react-router-dom";

export const Navbar = (props) => {

    // let navigate = useNavigate();

    const logout = () => {
        // AuthService.logout();
        // navigate('/');
        window.location.reload()
    }


    return (
        <div className={"menu"}>
            <span className={"s"}>
                {props.user ? (
                        <>
                            <button type={"menu-button"}
                                    className={'button-primary-outline'}
                                    onClick={() => logout()}>
                                Logout
                            </button>
                        </>
                    )
                    :
                    <>
                        <Link to={'/login'}>
                            <button type={"menu-button"}
                                    className={'button-primary-outline'}>
                                Sign in
                            </button>
                        </Link>
                        <Link to={'/employee'}>
                            <button type={"menu-button"}
                                    className={'button-primary'}>
                                Registration
                            </button>
                        </Link>
                    </>
                }
            </span>
        </div>
    );
}