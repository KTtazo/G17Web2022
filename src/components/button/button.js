import classnames from 'classnames';
import styles from './style.module.scss'
function Button({ children, onButtonClick, className, ...props}) {

  return (
    <div onClick={onButtonClick} {...props} className={classnames(styles['button'], className)}>
      {children}
    </div>
  );
}

export { Button };
