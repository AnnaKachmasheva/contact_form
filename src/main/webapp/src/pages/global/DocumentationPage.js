import styles from './DocumentationPage.module.scss'
import SyntaxHighlighter from 'react-syntax-highlighter';

export const DocumentationPage = () => {
    return (
        <div className={styles.window}>
            <div className={styles.navbar}>
                <h1>Documentation</h1>
                <ul>
                    <li><a href=''>Project Structure</a></li>
                    <li><a>Components</a>
                        <ul>
                            <li><a href='#buttons'>Buttons</a></li>
                            <li><a href='#inputs'>Inputs</a></li>
                        </ul>
                    </li>
                    <li><a href=''>Demo</a></li>
                </ul>
            </div>
            <div>
                <div className={styles.separator}></div>
                <div className={styles.separator}></div>
                <div className={styles.separator}></div>
                <div className={styles.contents} id={'components'}>
                    <h1>Components</h1>
                    <Buttons/>
                    <Inputs/>
                </div>
            </div>
        </div>
    )
}

const Buttons = () => {
    return (
        <div id={'buttons'}>
            <h2>Buttons</h2>

            <div className={styles.content}>
                <SyntaxHighlighter language="javascript">
                    {`<button className={'button-primary'}>Button</button>`}
                </SyntaxHighlighter>
                <button className={"button-primary"}
                        type={'button'}>
                    Button
                </button>
            </div>

            <div className={styles.content}>
                <SyntaxHighlighter language="javascript">
                    {`<button className={'button-primary sm'}>Button</button>`}
                </SyntaxHighlighter>
                <button className={"button-primary sm"}
                        type={'button'}>
                    Button
                </button>
            </div>

            <div className={styles.content}>
                <SyntaxHighlighter language="javascript">
                    {`<button className={'button-primary lg'}>Button</button>`}
                </SyntaxHighlighter>
                <button className={"button-primary lg"}
                        type={'button'}>
                    Button
                </button>
            </div>

        </div>
    )
}

const Inputs = () => {
    return (
        <div id={'inputs'}>

            <h2>Inputs</h2>

            <div className={styles.content}>
                <SyntaxHighlighter language="javascript">
                    {`<input className={'input-primary sm'} placeholder={'Input'}/>`}
                </SyntaxHighlighter>
                <input className={'input-primary sm'}
                       placeholder={'Input'}/>
            </div>

            <div className={styles.content}>
                <SyntaxHighlighter language="javascript">
                    {`<input className={'input-primary lg'} placeholder={'Input'}/>`}
                </SyntaxHighlighter>
                <input className={'input-primary lg'}
                       placeholder={'Input'}/>
            </div>


            <div className={styles.content}>
                <SyntaxHighlighter language="javascript">
                    {`<input className={'input-primary'} placeholder={'Input'}/>`}
                </SyntaxHighlighter>
                <input className={'input-primary'}
                       placeholder={'Input'}/>
            </div>

            <div className={styles.content}>
                <SyntaxHighlighter language="javascript">
                    {`<input className={'input-primary correct'} placeholder={'Input'}/>`}
                </SyntaxHighlighter>
                <input className={'input-primary correct'}
                       placeholder={'Input'}/>
            </div>

            <div className={styles.content}>
                <SyntaxHighlighter language="javascript">
                    {`<input className={'input-primary error'} placeholder={'Input'}/>`}
                </SyntaxHighlighter>
                <input className={'input-primary error'}
                       placeholder={'Input'}/>
            </div>

        </div>
    )
}
