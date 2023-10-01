using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SearchingBehaviour_Semana9_10 : StateMachineBehaviour
{
    [SerializeField] private float rotateSpeed;
    [SerializeField] private LayerMask layerMask;
    private Transform pickup;

    // OnStateEnter is called when a transition starts and the state machine starts to evaluate this state
    //override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    //{
    //
    //}

    // OnStateUpdate is called on each Update frame between OnStateEnter and OnStateExit callbacks
    override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        animator.transform.Rotate(Vector3.up * rotateSpeed * Time.deltaTime);
        //Debug.DrawRay(animator.transform.position - Vector3.up, animator.transform.forward * 30f, Color.black, 1f);
        RaycastHit hit;
        if(Physics.SphereCast(animator.transform.position + Vector3.up * 0.5f, 2f, animator.transform.forward, out hit, layerMask))
        {
            if(hit.transform.tag == "Pickable")
            {
                pickup = hit.collider.transform;
                animator.GetComponent<Semana9_10_CapsuleController>().SetTarget(pickup);
                animator.SetBool("detectedPickable", true);
            }
        }
    }

    // OnStateExit is called when a transition ends and the state machine finishes evaluating this state
    //override public void OnStateExit(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    //{
    // 
    //}

    // OnStateMove is called right after Animator.OnAnimatorMove()
    //override public void OnStateMove(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    //{
    //    // Implement code that processes and affects root motion
    //}

    // OnStateIK is called right after Animator.OnAnimatorIK()
    //override public void OnStateIK(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    //{
    //    // Implement code that sets up animation IK (inverse kinematics)
    //}
}
