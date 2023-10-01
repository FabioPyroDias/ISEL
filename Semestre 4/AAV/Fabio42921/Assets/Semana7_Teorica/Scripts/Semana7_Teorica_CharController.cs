using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Semana7_Teorica_CharController : MonoBehaviour
{
    private Animator animator;
    private CapsuleCollider capsuleCollider;

    [SerializeField] private float rotateSpeed;

    // Start is called before the first frame update
    void Start()
    {
        animator = GetComponent<Animator>();
        capsuleCollider = GetComponent<CapsuleCollider>();
    }

    // Update is called once per frame
    void Update()
    {
        animator.SetFloat("move_v", Input.GetAxis("Vertical"));
        animator.SetFloat("move_h", Input.GetAxis("Horizontal"));

        transform.Rotate(Vector3.up * Input.GetAxis("Mouse X") * Time.deltaTime * rotateSpeed);
    
        if(Input.GetKeyUp(KeyCode.K))
        {
            animator.SetTrigger("death");
        }

        if(Input.GetButtonDown("Jump"))
        {
            animator.SetTrigger("jump");
        }

        if(Input.GetButtonUp("Jump"))
        {
            animator.ResetTrigger("jump");
        }

        if(Input.GetButtonDown("Fire1"))
        {
            animator.SetTrigger("attack");
        }

        if(Input.GetButtonUp("Fire1"))
        {
            animator.ResetTrigger("attack");
        }

        float heightFactor = animator.GetFloat("collider_height");
        capsuleCollider.height = Mathf.Lerp(1.72f, 1.10f, heightFactor);
    }

    public void TryHit()
    {
        RaycastHit hit;
        if(Physics.Raycast(transform.position + Vector3.up, transform.forward, out hit, 1))
        {
            Hittable hittable = hit.transform.GetComponent<Hittable>();

            if(hittable != null)
            {
                hittable.GetHit();
            }
        }
    }
}