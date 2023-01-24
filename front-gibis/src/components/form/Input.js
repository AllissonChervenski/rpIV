import styles from './Input.module.css'

function Input({ type, text, name, placeholder, required, handleOnChange, value, className }) {
  return (
    <div className={styles.form_control}>
      <label htmlFor={name}>{text}:</label>
      <input
        type={type}
        name={name}
        id={name}
        placeholder={placeholder}
        onChange={handleOnChange}
        value={value}
        className={className}
        required={required}
      />
    </div>
  )
}

export default Input 